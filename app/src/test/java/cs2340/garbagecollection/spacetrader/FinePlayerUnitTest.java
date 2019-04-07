package cs2340.garbagecollection.spacetrader;
import android.app.Application;

import org.junit.Before;
import org.junit.Test;

import cs2340.garbagecollection.spacetrader.model.Player;
import cs2340.garbagecollection.spacetrader.viewmodel.PoliceViewModel;

import static org.junit.Assert.*;

/** Philena's JUnit to test the finePlayer() method in PoliceViewModel **/
public class FinePlayerUnitTest {

    private Player player1;
    private Player player2;
    private Player player3;
    private PoliceViewModel policeVM;

    @Before
    public void setUp() {

        policeVM = new PoliceViewModel(new Application());

        //player with credits < fine
        player1 = new Player("Bob", 4, 4, 4, 4);
        player1.setCredits(20);

        //player with credits > fine
        player2 = new Player("Waters", 4, 4, 4, 4);
        player2.setCredits(100);

        //player with credits == fine
        player3 = new Player("Robert", 4, 4, 4, 4);
        player3.setCredits(50);
    }

    @Test
    public void testFine() {

        //test finePlayer() when credits < fine
        policeVM.finePlayer(player1);
        assertEquals(0, player1.getCredits());

        //test finePlayer() when credits > fine
        policeVM.finePlayer(player2);
        assertEquals(50, player2.getCredits());

        //test finePlayer() when credits == fine
        policeVM.finePlayer(player3);
        assertEquals(0, player3.getCredits());
    }

}
