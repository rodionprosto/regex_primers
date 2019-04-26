



        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int index = 0;
        String FirstStr = "";
        String SecondStr = "";
        char Symbol = '+';
        //Здесь идет регулярное выражение
        //Это шаблоны, которым
        // должны соответствовать строки
        // здесь шаблон {число}+{число}
        Pattern pattern = Pattern.compile("\\d+(\\+|\\-|\\*|\\/)\\d+");
        //выражение "\\d" - это все числа,
        //  а "+" после этого выражения говорит о том,
        // что этих чисел должно быть минимум 1.
        // "\\+" - просто знак плюса



        Matcher matcher = pattern.matcher(input);
        //класс Matcher проверяет нашу строку (input)
        //с нашим регулярным выражением (pattern)

        //метод matches() проверяет, соответствует ли
        //наш input шаблону
        if ( matcher.matches() ){
            for (int i = 0; i < input.length(); i++){
                if (input.charAt(i)== '+' | input.charAt(i)== '-' |
                        input.charAt(i)== '/' | input.charAt(i)== '*'){
                    index = i;
                    Symbol = input.charAt(i);
                    break;
                }
            }

            for (int i = 0; i < index; i++){
                FirstStr += input.charAt(i);
            }

            for (int i = index+1; i < input.length(); i++){
                SecondStr += input.charAt(i);
            }

            float FirstInt = Float.parseFloat(FirstStr);
            float SecondInt = Float.parseFloat(SecondStr);
            System.out.print(GetRes(FirstInt, SecondInt, Symbol));
        }
        else{
            System.out.print("некорректно");
        }
    }

    private static double GetRes(float firstInt, float secondInt, char symbol) {
        switch (symbol){
            case '-': return firstInt-secondInt;
            case '*': return firstInt*secondInt;
            case '/': return firstInt/secondInt;
        }
        return firstInt+secondInt;
    }


}
