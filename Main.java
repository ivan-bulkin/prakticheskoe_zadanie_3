package prakticheskoe_zadanie_3;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        privetstvie_Programmi();
        vibiraem_Igru();

    }

    private static void privetstvie_Programmi() {
        System.out.print("\u001B[30m");//это чёрный цвет
/*        System.out.print("\u001B[31m");//это красный цвет
        System.out.print("\u001B[32m");//это ярко-зелёный цвет
        System.out.print("\u001B[33m");//это коричневый цвет
        System.out.print("\u001B[34m");//это синий цвет
        System.out.print("\u001B[35m");//это фиолетовый цвет*/
        System.out.println("\nПрактическое задание по уроку № 3");
        System.out.println("Выберите игру:");
        System.out.println("1. Угадай Число");
        System.out.println("2. Угадай Слово");
        System.out.println("0. Выход из программы");
        System.out.println("Сделал Иван Булкин");
        System.out.printf("Ваш выбор (1, 2 или 0): ");
    }

    private static void vibiraem_Igru() {
        while (true) {
            String n = in.next();
            switch (n) {
                case "1":
                    igra_Ugaday_chislo();
                    privetstvie_Programmi();
                    break;
                case "2":
                    igra_Ugaday_slovo();
                    privetstvie_Programmi();
                    break;
                case "0":
                    doExit();
                default:
                    System.out.println("Вы ввели: " + n + ", такого значения нет в списке\n" + "Выберите значения от 1, 2 или 0 и попробуйте ещё разик.");
                    System.out.printf("Ваш выбор (1, 2 или 0): ");
            }
        }
    }

    private static void povtorit_igru_Ugaday_chislo() {
        System.out.print("\u001B[30m");//это чёрный цвет
        System.out.println("Повторить игру Угадай Число еще раз ? 1 – да, повторить / 0 – нет, хватит, я наигрался.");
        String n = in.next();
        switch (n) {
            case "1" -> {
                igra_Ugaday_chislo();
                break;
            }
            case "0" -> {
                break;
            }
            default -> {
                System.out.printf("Вы ввели: " + n + ", такого значения нет в списке%n" + "Выберите 1 или 0 и попробуйте ещё разик.");
                System.out.println();
                povtorit_igru_Ugaday_chislo();
            }
        }
    }

    private static void igra_Ugaday_chislo() {
        System.out.println("\nИгра Угадай Число.           Правила игры:");
        System.out.println("Вы должны за три попытки угадать загаданное нами число от 0 до 9-ти.");
        System.out.println("Если Вы не угадали, мы напишем, меньше или больше Ваше число загаданного нами числа.");
        int zagadannoe_chislo = (int) (Math.random() * 10);
        int polzovatel = -100;
        for (int i = 1; i < 4; i++) {
            polzovatel = vvod_chisla_ot_0_do_9();
            if (polzovatel == zagadannoe_chislo) {
                System.out.print("\u001B[32m");
                if (i == 1) {
                    System.out.println("Поздравляем, Вы угадали с первой попытки. " + zagadannoe_chislo + " = " + polzovatel);
                    povtorit_igru_Ugaday_chislo();
                    return;
                }
                if (i == 2) {
                    System.out.println("Поздравляем, Вы угадали с второй попытки. " + zagadannoe_chislo + " = " + polzovatel);
                    povtorit_igru_Ugaday_chislo();
                    return;
                }
                if (i == 3) {
                    System.out.println("Поздравляем, Вы угадали с третьей попытки. " + zagadannoe_chislo + " = " + polzovatel);
                    povtorit_igru_Ugaday_chislo();
                    return;
                }
            }
            if (polzovatel != -100) {
                if (zagadannoe_chislo > polzovatel & i != 3) {
                    System.out.printf("Ваше число меньше загаданного нами");
                }
                if (zagadannoe_chislo < polzovatel & i != 3) {
                    System.out.printf("Ваше число больше загаданного нами");
                }
                if (i == 1) {
                    System.out.println(", осталось две попытки.");
                }
                if (i == 2) {
                    System.out.println(", осталась одна попытка.");
                }
                if (i == 3) {
                    System.out.print("\u001B[31m");
                    System.out.println("Вы проиграли. Загаданное число было: " + zagadannoe_chislo);
                    povtorit_igru_Ugaday_chislo();
                }
            } else {
                System.out.print("Вы ощиблись, ");
                i--;
            }
        }
    }

    private static int vvod_chisla_ot_0_do_9() {
        System.out.print("Введите число от 0 до 9-ти: ");
        int vvedennoe_chislo = -100;
        if (in.hasNextInt()) {
            vvedennoe_chislo = in.nextInt();
            if (vvedennoe_chislo < 0 || vvedennoe_chislo > 9) {
                vvedennoe_chislo = -100;
            }
        } else {
            in.next();
        }
        return vvedennoe_chislo;
    }
/*        System.out.print("Введите число от 0 до 9-ти: ");
        int vvedennoe_chislo = in.hasNextInt() ? in.nextInt() : -100;
        if (vvedennoe_chislo == -100) {
            in.next();

        }
        return vvedennoe_chislo;*/
/*        if (vvedennoe_chislo < 0 || vvedennoe_chislo > 9) {
            vvedennoe_chislo = -100;
            return vvedennoe_chislo;
        }
        return vvedennoe_chislo;*/

/*        int vvedennoe_chislo = -100;
        System.out.printf("Введите Ваше число: ");
        vvedennoe_chislo = in.hasNextInt() ? in.nextInt() : -100;

        if (in.hasNextInt()) {
            vvedennoe_chislo = in.nextInt();
            if (vvedennoe_chislo < 0) {
                System.out.println("Вы ввели число меньше нуля, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
                vvod_chisla_ot_0_do_9();
            }
            if (vvedennoe_chislo > 9) {
                System.out.println("Вы ввели число больше 9, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
                vvod_chisla_ot_0_do_9();
            }
            return vvedennoe_chislo;
        } else {
            System.out.printf("Вы ввели не число, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
            vvod_chisla_ot_0_do_9();
        }
        return 0;*/

/*        int vvedennoe_chislo = in.hasNextInt() ? in.nextInt() : -100;
        if (vvedennoe_chislo == -100) {
            System.out.printf("Вы ввели не число, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
            return;
        }
        if (vvedennoe_chislo <0) {
            System.out.printf("Вы ввели число меньше нуля, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
            return;
        }
        if (vvedennoe_chislo >9) {
            System.out.printf("Вы ввели число больше 9, надо ввести число от 0 до 9-ти, попробуйте ещё разик");
            return;
        }*/

    private static void igra_Ugaday_slovo() {
        System.out.println("\nИгра Угадай Слово.           Правила игры:");
        System.out.println("Вы должны угадать загаданное нами слово на английском языке. Будем играть до тех пор, пока Вы не угадаете.");
        System.out.println("После каждой Вашей попытки мы будем показывать буквы, которые стоят на своих местах. Используем только маленькие буквы.");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int nomer_zagadannogo_slova = (int) (Math.random() * 25);//Случайным образом выбираем загаданное слово, всего 25-слов
        String zagadannogo_slovo = words[nomer_zagadannogo_slova];
//        System.out.println("Загаданное слово: " + zagadannogo_slovo);//Выводим загаданное слово, чтобы было легко проверить работоспособность программы
        proverayem_slovo(zagadannogo_slovo, 0);
//        polzovatelskoe_slovo.charAt(0);
    }

    private static void proverayem_slovo(String zagadannogo_slovo, int kol_vo_popitok) {
        kol_vo_popitok++;
        System.out.printf("Ваше слово: ");
        String polzovatelskoe_slovo = in.next();
        int skolko_bukv_ugadano = 0;
        for (int i = 0; i < 15; i++) {
            if (i < polzovatelskoe_slovo.length() & i < zagadannogo_slovo.length()) {
                if (polzovatelskoe_slovo.charAt(i) == zagadannogo_slovo.charAt(i)) {
                    System.out.print("\u001B[32m");//это ярко-зелёный цвет
                    System.out.printf(String.valueOf(polzovatelskoe_slovo.charAt(i)));
                    System.out.print("\u001B[30m");//это чёрный цвет
                    skolko_bukv_ugadano++;
                    if (skolko_bukv_ugadano == zagadannogo_slovo.length()) {
                        System.out.println("\nПоздравляем, Вы угадали загаданное слово: " + zagadannogo_slovo + " Количество Ваших попыток: " + kol_vo_popitok);
                        return;
                    }
                } else {
                    System.out.printf("#");
                }
            } else {
                System.out.printf("#");
            }
        }
        System.out.println();
        proverayem_slovo(zagadannogo_slovo, kol_vo_popitok);
    }

    private static void doExit() {
        System.out.println("\nВыходим из программы, Вы уверены? y/n (д/н)");
        String n = in.next();
        switch (n) {
            case "y", "yes", "д", "да", "+", "торжественно подтверждаю" -> {
                System.out.println("\nДо новых встреч, ждём Вас снова.");
                in.close();//Необходимо закрыть объект in
                System.exit(0);
            }
            case "n", "н", "-", "играть, так играть, продолжаем" -> {
                System.out.println();
                privetstvie_Programmi();
                vibiraem_Igru();
                break;
            }
            default -> {
                System.out.printf("Вы ввели: " + n + ", такого значения нет в списке%n" + "Выберите y/n или д/н и попробуйте ещё разик.");
                doExit();
            }
        }
    }
}
