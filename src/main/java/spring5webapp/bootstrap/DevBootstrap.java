package spring5webapp.bootstrap;

import spring5webapp.domain.Author;
import spring5webapp.domain.Book;
import spring5webapp.domain.Publisher;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import spring5webapp.repositories.AuthorRepository;
import spring5webapp.repositories.BookRepository;
import spring5webapp.repositories.PublisherRepository;
import org.springframework.stereotype.Component;

/**
 * Created by scb on 8/27/22.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>  {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //publisher1
        Publisher publisher1 = new Publisher("foo", "12th Street", "LA", "CA", "90210");
        publisherRepository.save(publisher1);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher1);
        publisher1.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher1);

        //publisher2
        Publisher publisher2 = new Publisher("bar", "13th Street", "LA", "CA", "90211");
        publisherRepository.save(publisher2);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.getAuthors().add(eric);
        noEJB.setPublisher(publisher2);
        publisher2.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
