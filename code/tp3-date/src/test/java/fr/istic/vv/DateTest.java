package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void testConstructeurCas1() {
        try {
            Date date = new Date(15, 6, 2023);

            assertNotNull(date);
            assertEquals(15, date.getDay());
            assertEquals(6, date.getMonth());
            assertEquals(2023, date.getYear());
        }
        catch (NotADateException e){
            fail("Une exception a été jetée");
        }
    }

    @Test
    void testConstructeurCas2() {
        assertDoesNotThrow(() -> new Date(29, 2, 2024));
    }

    @Test
    void testConstructeurCas3() {
        assertThrows(NotADateException.class, () -> new Date(29, 2, 2023));
    }

    @Test
    void testConstructeurCas4() {
        assertThrows(NotADateException.class, () -> new Date(0, 6, 2023));
    }

    @Test
    void testConstructeurCas5() {
        assertThrows(NotADateException.class, () -> new Date(15, 0, 2023));
    }

    void testConstructeurCas6() {
        assertThrows(NotADateException.class, () -> new Date(15, 13, 2023));
    }
    @Test
    void testIsLeapYearCas1() {
        assertTrue(Date.isLeapYear(2000));
    }

    @Test
    void testIsLeapYearCas2() {
        assertTrue(Date.isLeapYear(2024));
    }

    @Test
    void testIsLeapYearCas3() {
        assertFalse(Date.isLeapYear(1900));
    }

    @Test
    void testIsLeapYearCas4() {
        assertFalse(Date.isLeapYear(2023));
    }

    @Test
    void testNextDateCas1() throws NotADateException {
        Date date = new Date(14, 6, 2023);
        Date next = date.nextDate();
        assertEquals(0, new Date(15, 6, 2023).compareTo(next));
    }

    @Test
    void testNextDateCas2() throws NotADateException {
        Date date = new Date(31, 1, 2023);
        Date next = date.nextDate();
        assertEquals(0, new Date(1, 2, 2023).compareTo(next));
    }

    @Test
    void testNextDateCas3() throws NotADateException {
        Date date = new Date(31, 12, 2023);
        Date next = date.nextDate();
        assertEquals(0, new Date(1, 1, 2024).compareTo(next));
    }

    @Test
    void testPreviousDateCas1() throws NotADateException {
        Date date = new Date(15, 6, 2023);
        Date previous = date.previousDate();
        assertEquals(0, new Date(14, 6, 2023).compareTo(previous));
    }

    @Test
    void testPreviousDateCas2() throws NotADateException {
        Date date = new Date(1, 3, 2023);
        Date previous = date.previousDate();
        assertEquals(0, new Date(28, 2, 2023).compareTo(previous));
    }

    @Test
    void testPreviousDateCas3() throws NotADateException {
        Date date = new Date(1, 1, 2023);
        Date previous = date.previousDate();
        assertEquals(0, new Date(31, 12, 2022).compareTo(previous));
    }

    @Test
    void testGetNumberOfDayByMonthCas1() {
        assertEquals(29, Date.getNumberOfDaysByMonth(2, 2024));
    }

    @Test
    void testGetNumberOfDayByMonthCas2() {
        assertEquals(28, Date.getNumberOfDaysByMonth(2, 2023));
    }

    @Test
    void testGetNumberOfDayByMonthCas3() {
        assertEquals(30, Date.getNumberOfDaysByMonth(4, 2023));
    }

    @Test
    void testGetNumberOfDayByMonthCas4() {
        assertEquals(31, Date.getNumberOfDaysByMonth(7, 2023));
    }

    @Test
    void testGetNumberOfDayByMonthCas5() {
        assertEquals(31, Date.getNumberOfDaysByMonth(8, 2023));
    }

    @Test
    void testGetNumberOfDayByMonthCas6() {
        assertEquals(30, Date.getNumberOfDaysByMonth(11, 2023));
    }

    @Test
    void testCompareToCas1() throws NotADateException {
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(1, 1, 2023);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void testCompareToCas2() throws NotADateException {
        Date date1 = new Date(1, 6, 2023);
        Date date2 = new Date(2, 5, 2023);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void testCompareToCas3() throws NotADateException {
        Date date1 = new Date(15, 6, 2023);
        Date date2 = new Date(14, 6, 2023);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void testCompareToCas4() throws NotADateException {
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2023);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void testCompareToCas5() throws NotADateException {
        Date date1 = new Date(1, 4, 2023);
        Date date2 = new Date(2, 5, 2023);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void testCompareToCas6() throws NotADateException {
        Date date1 = new Date(10, 6, 2023);
        Date date2 = new Date(11, 6, 2023);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void testCompareToCas7() throws NotADateException {
        Date date1 = new Date(15, 6, 2023);
        Date date2 = new Date(15, 6, 2023);
        assertEquals(0, date1.compareTo(date2));
    }

    @Test
    void testCompareToCas8() throws NotADateException {
        Date date1 = new Date(15, 6, 2023);
        assertThrows(NullPointerException.class, () -> date1.compareTo(null));
    }

}