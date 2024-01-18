/* PLEASE SEE:
----------------------------------------------------------------------------------------------------------------
 * Inspiration for this game & solution was drawn from a practical I did at the University of Pretoria in 2022.
 * Further the following website helped me with specifics of the program; 
 * https://towardsdatascience.com/tower-of-hanoi-a-recursive-approach-12592d1a7b20
----------------------------------------------------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.Scanner;

class Disk {

    /*
     * DISK OBJECTS
     * Create a disk object with member size
     * Size will denote the size of the disk, i.e. 1, 2, 3, 4, 5
     * We know disk of size 1 can be placed on top of disk of size 2, but not vice
     * versa
     */

    // Member variable
    private int size;

    // Constructor
    public Disk(int size) {
        this.size = size;
    }

    // Getter
    public int getSize() {
        return size;
    }
}

class Tower {

    /*
     * TOWER OBJECTS
     * Create a tower object with member disks
     * ArrayList disks will denote the disks on the tower
     * We know that the disks on the tower must be in ascending order
     */

    // Member variable
    private ArrayList<Disk> disks;
    private int towerNum; // 1 - Start Tower, 2 - Temp Tower, 3 - Goal Tower

    public Tower(){}

    // Constructor
    public Tower(int num) {
        disks = new ArrayList<Disk>();
        this.towerNum = num;
    }

    // Getters
    public int getTowerNum() {
        return towerNum;
    }

    public String getTower() {
        if (towerNum == 1) {
            return "Start Tower";
        } else if (towerNum == 2) {
            return "Temp Tower";
        } else {
            return "Goal Tower";
        }
    }

    public boolean validMove(Tower dep, Tower dest) {
        if (dest.getDisk(dest) == null || dep.getDisk(dep).getSize() < dest.getDisk(dest).getSize() ) {
            return true;
        } else {
            return false;
        }
    }

    // Methods to add, move & remove Disks to the tower
    public void addDisk(Disk disk) {
        if (disks.size() == 0) {
            disks.add(disk);
        } else {
            if (disks.get(disks.size() - 1).getSize() > disk.getSize()) { // Checks if the disk being added is smaller
                // than the top disk
                disks.add(disk);
            } else {
                System.out.println("Invalid Move");
            }
        }
    }

    public void removeDisk() {
        if (disks.size() == 0) {
            System.out.println("Invalid Move");
        } else {
            disks.remove(disks.size() - 1);
        }
    }

    public Disk getDisk(Tower tower) {
        if (disks.size() == 0) {
            //System.out.println("No disks on tower " + tower.getTower());
            return null;
        } else {
            return disks.get(disks.size() - 1);
        }
    }

    public void moveDisk(Tower dep, Tower dest) {
        if (validMove(dep, dest)) {
            dest.addDisk(dep.getDisk(dep));
            dep.removeDisk();
        } else {
            System.out.println("Invalid Move");
        }
    }

    public void printTower() {
        for (int i = 0; i < disks.size(); i++) {
            System.out.print(disks.get(i).getSize() + " ");
        }
        System.out.println();
    }

}

class TowersOfHanoi {
    // Three towers - Start Tower, Temp Tower, Goal Tower
    private Tower startTower, tempTower, goalTower;

    public TowersOfHanoi(){}

    public TowersOfHanoi(int numDisks) {
        startTower = new Tower(1);
        tempTower = new Tower(2);
        goalTower = new Tower(3);
        for (int i = numDisks; i > 0; i--) {
            startTower.addDisk(new Disk(i));
        }
    }

    public boolean validateGame() {
        if (startTower.getDisk(startTower).getSize() >= 3) {
            return true;
        } else if (tempTower.getDisk(tempTower) == null) {
            return false;
        } else if (goalTower.getDisk(goalTower) == null) {
            return false;
        } else {
            return false;
        }
    }

    // Solver for the game
    public void solve(int numDisks, Tower startTower, Tower tempTower, Tower goalTower) {
        // This is a recursive solution to the Towers of Hanoi game.
        if (numDisks == 1) {
            startTower.moveDisk(startTower, goalTower);
            System.out.println(
                    "Move disk " + numDisks + " from " + startTower.getTower() + " to " + goalTower.getTower());
        } else {
            solve(numDisks - 1, startTower, goalTower, tempTower);
            startTower.moveDisk(startTower, goalTower);
            System.out.println(
                    "Move disk " + numDisks + " from " + startTower.getTower() + " to " + goalTower.getTower());
            solve(numDisks - 1, tempTower, startTower, goalTower);
        }
    }

    public void printTowers() {
        System.out.println("Start Tower: ");
        startTower.printTower();
        System.out.println("Temp Tower: ");
        tempTower.printTower();
        System.out.println("Goal Tower: ");
        goalTower.printTower();
    }

    public static void main(String[] args) {
        // Ask user for number of disks
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numberOfDisks = sc.nextInt();

        TowersOfHanoi game = new TowersOfHanoi(numberOfDisks);
        game.printTowers();
        game.solve(numberOfDisks, game.startTower, game.tempTower, game.goalTower); // Solve the game
        game.printTowers();
    }
}