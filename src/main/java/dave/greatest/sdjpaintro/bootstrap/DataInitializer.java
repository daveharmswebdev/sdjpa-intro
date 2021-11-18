package dave.greatest.sdjpaintro.bootstrap;

import dave.greatest.sdjpaintro.domain.AuthorUuid;
import dave.greatest.sdjpaintro.domain.Book;
import dave.greatest.sdjpaintro.repositories.AuthorUuidRepository;
import dave.greatest.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorUuidRepository = authorUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring in action", "2323232", "Your MOM", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll()
                .forEach(book -> {
                    System.out.println("Book title: " + book.getTitle() + " -- Id: " + book.getId());
                });

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthor.getId() );

    }
}
