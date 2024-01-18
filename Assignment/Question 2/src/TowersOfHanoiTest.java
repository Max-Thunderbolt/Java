import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TowersOfHanoiTest {

    @Test
    public void testValidMove(){
        Tower test = new Tower();

        Disk small = new Disk(1);

        Tower departureTower = new Tower(1);
        departureTower.addDisk(small);
        Tower destinationTower = new Tower(2);

        boolean expected = true;
        boolean result = test.validMove(departureTower, destinationTower);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testValidMove_InvalidMove(){
        Tower test = new Tower();

        Disk small = new Disk(1);
        Disk large = new Disk(3);

        Tower departureTower = new Tower(1);
        departureTower.addDisk(large);
        Tower destinationTower = new Tower(2);
        destinationTower.addDisk(small);

        boolean expected = false;
        boolean result = test.validMove(departureTower, destinationTower);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetTower(){
        Tower test = new Tower();
        Tower startTower = new Tower(1);
        Tower tempTower = new Tower(2);
        Tower goalTower = new Tower(3);

        String expected = "Start Tower";
        String result = startTower.getTower();
        String expected2 = "Temp Tower";
        String result2 = tempTower.getTower();
        String expected3 = "Goal Tower";
        String result3 = goalTower.getTower();

        Assert.assertEquals(expected,result);
        Assert.assertEquals(expected2,result2);
        Assert.assertEquals(expected3,result3);
    }

    @Test
    public void testAddDisk(){
        Disk small = new Disk(1);

        Tower tower = new Tower(1);
        tower.addDisk(small);

        Tower test = new Tower();

        boolean expected = true, result = false;
        if(tower.getDisk(tower).getSize() != 0){
            result = true;
        }

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMoveDisk(){
        Tower test = new Tower();
        Tower startTower = new Tower(1);
        Tower endTower = new Tower(2);

        Disk small = new Disk(1);
        startTower.addDisk(small);

        test.moveDisk(startTower, endTower);

        boolean expected = true, result = false;
        if (endTower.getDisk(endTower).getSize() != 0){
            result = true;
        }

        Assert.assertEquals(expected, true);
    }
}

// Generated with love by TestMe :) Please report issues and submit feature
// requests at: https://weirddev.com/forum#!/testme