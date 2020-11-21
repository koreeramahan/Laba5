import java.util.Scanner;
import Game.*;

public class Main
{
    final static String PLAYER_NAME = "Олеся";
    final static String ENEMY_NAME = "Рандомный Чувак";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player(PLAYER_NAME);
        Enemy enemy = new Enemy(ENEMY_NAME);
        //пока не закончатся жизни
        while (player.getHealth()>0 && enemy.getHealth()>0)
        {
            System.out.println("Введите число от " + Person.MIN_NUMBER + " до " + Person.MAX_NUMBER);
            int number = sc.nextInt(); //пытаемся угадать число
            byte playerRes = player.attack(enemy,number); //сравниваем загаданное число с предполагаемым
            //результат атаки игрока
            switch (playerRes)
            {
                case 1:
                    System.out.println("Вы не угадали. Загаданное число больше.");
                    break;
                case -1:
                    System.out.println("Вы не угадали. Загаданное число меньше.");
                    break;
                default:
                    int enemyHealth=enemy.getHealth(); //число жизней врага
                    if (enemyHealth>0) System.out.println("Вы угадали. У врага с именем " + enemy.getName()
                            + " осталось " + enemyHealth + " жизней!");
                    else System.out.println("Вы убили врага с именем " + enemy.getName());
            }
            //результат атаки врага
            if (enemy.attack(player))
            {
                int playerHealth = player.getHealth(); //число наших жизней
                if (playerHealth>0) System.out.println("Враг угадал число. У игрока " +
                        player.getName() + " осталось " + playerHealth + " жизней.");
                else System.out.println("Вас убили!");
            }
            else System.out.println("Враг не угадал число.");
        }
        sc.close();
    }
}
