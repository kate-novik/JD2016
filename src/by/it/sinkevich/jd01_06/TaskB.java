package by.it.sinkevich.jd01_06;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание В.
 *
 * @author Sinkevich Denis
 */
class TaskB {

    String task1() {
        //Создаём стрингбилдер с текстом стиха для последующего удаления слов в нём
        StringBuilder poem = new StringBuilder(PoemText.getPoemtext());
        //Паттерн для поиска нужных слов
        Pattern pattern = Pattern.compile("\\b[[а-яА-Я]&&[^АаЕеЁёИиОоУуЫыЭэЮюЯя]][а-я]{4}\\b");
        Matcher matcher = pattern.matcher(PoemText.getPoemtext());
        //Список для хранения индексов вхождения паттерна
        List<Integer> index = new LinkedList<>();
        while (matcher.find()) {
            //Заполняем список в обратном порядке, для более удобной работы по удалению слов из poem
            index.add(0, matcher.start());
        }
        //Удаление слов
        for (int number : index) {
            poem.delete(number, number + 5);
        }
        System.out.println("Из текста удалить все слова длины 5, начинающиеся га согласную букву.");
        return poem.toString();
    }

    void task2() {
        //Паттерн для разделения всего текста на предложения
        Pattern pattern = Pattern.compile("[.!?;]+");
        String[] sentences = pattern.split(PoemText.getPoemtext());
        //Отсортированный словарь: ключ -- количество слов в предложении, значение -- предложения разделённые символом '#'
        Map<Integer, String> result = new TreeMap<>();
        String splitter = "#";
        //Перебираем все предложения, подсчитываем кол-во слов в каждом и заносим их в словарь
        for (String sentence : sentences) {
            //Убираем все переносы строк и лишние пробелы
            sentence = sentence.replaceAll("\\s+", " ").trim();
            //Паттерн для поиска слов в предложении
            pattern = Pattern.compile("\\b[А-Яа-яЁё]+\\b");
            Matcher matcher = pattern.matcher(sentence);
            int wordCount = 0;
            while (matcher.find()) {
                wordCount++;
            }
            //Заносим предложения в словарь, если в нём уже содержится предложения с таким количеством слов, то заносим его
            //через разделитель путём конкатенации к предыдущему предложению
            if (!result.containsKey(wordCount)) {
                result.put(wordCount, sentence);
            } else {
                result.put(wordCount, result.get(wordCount).concat(splitter).concat(sentence));
            }
        }
        System.out.println("Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них." +
                " В предложениях убрать переносы строк.");
        //Выводе уже автоматически отсортированной коллекции
        for (Integer key : result.keySet()) {
            System.out.println("Предложения в которых " + key + " слов(слова): ");
            if (result.get(key).contains("#")) {
                String[] values = result.get(key).split("#");
                for (String value : values) {
                    System.out.println(value);
                }
            } else {
                System.out.println(result.get(key));
            }
        }
    }

    void task3(String symbol) {
        //Делим текст на слова с помощью паттерна
        Pattern pattern = Pattern.compile("[^А-Яа-яЁё]+");
        String[] words = pattern.split(PoemText.getPoemtext());
        //Сортируем список методом пузырька используя метод myCompareTo() для сравнения слов
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (myCompareTo(words[j], words[j + 1], symbol) > 0) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        //Выводим результат
        System.out.println("Отсортировать слова в тексте по убыванию количества вхождений заданного символа," +
                " а в случае равенства -- по алфавиту.");
        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     * Метод сравнивает две строки, первичная сортировка по убыванию количества вхождений символа {@code String symbol},
     * вторичная по алфавиту не учитывая регистр
     *
     * @param oneString     Первая строка
     * @param anotherString Вторая строка
     * @param symbol        Символ, кол-во вхождений которого учитывается при сортировке
     * @return Возвращает значение типа {@code int}. Если строки равны, то значение равно нулю, если первая строка больше второй,
     * то значение меньше нуля, если вторая строка больше первой, то значение больше нуля
     */
    private int myCompareTo(String oneString, String anotherString, String symbol) {
        //С помощью матчера считаем кол-во вхождений нужного символа в каждой строке
        Pattern pattern = Pattern.compile(symbol);
        Matcher matcherOne = pattern.matcher(oneString);
        Matcher matcherAnother = pattern.matcher(anotherString);
        int countOne = 0;
        while (matcherOne.find()) {
            countOne++;
        }
        int countAnother = 0;
        while (matcherAnother.find()) {
            countAnother++;
        }
        //Само сравнение
        if (countOne != countAnother) {
            return countAnother - countOne;
        } else {
            return oneString.compareToIgnoreCase(anotherString);
        }
    }
}
