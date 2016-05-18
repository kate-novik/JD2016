package by.it.smirnova.jd01_08;


public enum PrinterState {
    PRINTING, WAITING;

    public String toString()
    {
        switch (this)
        {
            case PRINTING: return "Печатаем страницу";
            case WAITING: return "Ожидаем новую страницу";
        }

        return "Неизвестный статус";
    }
}
