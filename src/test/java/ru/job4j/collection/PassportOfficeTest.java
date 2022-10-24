package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTwoSame() {
        Citizen peterArsentev = new Citizen("2f44a", "Petr Arsentev");
        Citizen vasilyKoshkin = new Citizen("2f44a", "Vasily Koshkin");
        PassportOffice office = new PassportOffice();
        office.add(peterArsentev);
        office.add(vasilyKoshkin);
        assertThat(office.add(vasilyKoshkin)).isFalse();
    }
}