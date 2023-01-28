package designpattens.strategy.example2;

public class CounterStrike {
    public static void main(String[] args) {
        Player terrorrist = new Player("Terrorist");
        Player counter_terrorrist = new Player("Counter Terrorist");

        System.out.println("Before bomb is planted");
        terrorrist.setStrategy(new AgressiveStrategy());
        counter_terrorrist.setStrategy(new DefensiveStrategy());

        terrorrist.action(); /*  call action from Aggressive Strategy  */
        counter_terrorrist.action(); /*  call action from Defensive Strategy  */

        System.out.println("After bomb is planted");
        terrorrist.setStrategy(new DefensiveStrategy());
        counter_terrorrist.setStrategy(new AgressiveStrategy());

        terrorrist.action(); /*  call action from   Defensive Strategy  */
        counter_terrorrist.action(); /*  call action from Aggressive Strategy  */
    }
}
