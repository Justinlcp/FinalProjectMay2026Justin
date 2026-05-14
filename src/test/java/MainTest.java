import org.example.domain.Book;
import org.example.domain.ItemStatus;
import org.example.domain.Library;
import org.example.domain.Student;
import org.example.exceptions.BorrowLimitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Student successfully borrows a book")
    void testBorrowItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Assertions.assertEquals(ItemStatus.BORROWED, book.getStatus());
    }

    @Test
    @DisplayName("Borrowed items list increases after borrowing")
    void testBorrowItem2() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Assertions.assertEquals(1, student.getBorrowedItems().size());
    }
}