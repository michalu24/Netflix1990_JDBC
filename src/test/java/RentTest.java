import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentTest {

    @Test
    void showAvailableMovies() {
        //Given
        //When
        Rent rent1 = new Rent();
        //then
        rent1.showAvailableMovies();
    }
}