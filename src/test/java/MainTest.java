import org.example.domain.*;
import org.example.exceptions.BorrowLimitException;
import org.example.exceptions.ItemNotAvailableException;
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

    @Test
    @DisplayName("Student successfully returns a book")
    void testReturnItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        library.returnItem(student, book);
        Assertions.assertEquals(ItemStatus.IN_STORE, book.getStatus());
    }

    @Test
    @DisplayName("Borrowed items list decreases after returning")
    void testReturnItem2() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        library.returnItem(student, book);
        Assertions.assertEquals(0, student.getBorrowedItems().size());
    }

    @Test
    @DisplayName("Borrowing an already borrowed item throws ItemNotAvailableException")
    void testBorrowAlreadyBorrowedItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Teacher teacher = new Teacher("Bob");
        Assertions.assertThrows(ItemNotAvailableException.class, () -> library.borrowItem(teacher, book));
    }
}