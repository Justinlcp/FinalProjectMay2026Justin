import org.example.domain.Book;
import org.example.domain.ItemStatus;
import org.example.domain.Library;
import org.example.domain.Student;
import org.junit.jupiter.api.BeforeEach;

public class MainTest {

    private Library library;
    private Student student;
    private Book book;

    @BeforeEach
    void setUp() {
        library = new Library();
        student = new Student("Alice");
        book = new Book("Java Book", ItemStatus.IN_STORE, "1234567890123", "John", "Education");
        library.addUser(student);
        library.addItem(book);
    }
}