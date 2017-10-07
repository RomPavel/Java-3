/*
 Павел Ромашевский, 2 курс 5 группа
 Лабораторная работа №3
 Вариант 8
 "Из текста удалить все слова заданной длины, начинающиеся на согласную букву."
  */



import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static String deleteWords(String tochange, int l) {

        final String delimiters = " .,!:;\"\n\t\r\f ";
        final String consonants = "qwrtpsdfghjklzxcvbnmQWRTPSDFGHJKLZXCVBNM";

        StringBuilder answer = new StringBuilder();

        StringTokenizer withdel = new StringTokenizer(tochange, delimiters, true);
        while (withdel.hasMoreTokens()) {
            String token = withdel.nextToken();

            if ((consonants.indexOf(token.charAt(0))==-1)||token.length()!=l)
                 answer.append(token);
        }
        return answer.toString();
    }
    public static void main(String[] args) {

        String[] text = new String[50];
        int length = 0;
        int count = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter your text. Write 'exit' on new line to stop");
        while (in.hasNextLine()) {

            text[count] = new String(in.nextLine());
            if(text[count].equals("exit")) break;
            count++;
        }

        in = new Scanner(System.in);
        System.out.println("Enter word length.");
        length = in.nextInt();

        for (int i = 0 ; i < count; i++)
            text[i]=deleteWords(text[i], length);

        System.out.println("After deleting words:");
        for (int i = 0; i < count; i++)
            System.out.println(text[i]);
    }
}
