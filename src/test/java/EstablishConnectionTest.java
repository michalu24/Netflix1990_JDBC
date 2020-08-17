import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstablishConnectionTest {

    @Test
    public void shouldEstablishConnection() {
        //given
        //when
        //then
        EstablishConnection connection = new EstablishConnection();
    }

    @Test
    void shutDownConnection() {
        //given
        //when
        EstablishConnection connection = new EstablishConnection();
        //then
        connection.shutDownConnection();

    }
}