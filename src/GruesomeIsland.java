package src;

public class GruesomeIsland {
    public static void main(String[] args) {
        World world = new World(10);
        world.showMatrix();
        try {
            int[] test = new int[2];
            test = world.chunks[3][3].getAdjacentChunk("East");

            System.out.print(test[0]);
            System.out.println(test[1]);

            world.chunks[0][0].receiveSounds(new Sound(1, "the gods", "heavens"));
            world.chunks[0][0].receiveSounds(new Sound(9, "Henry", "chungo chingar"));
            test = world.chunks[0][0].getAdjacentChunk("South");
            System.out.print(test[0]);
            System.out.println(test[1]);

            Player testPlayer = new Player("Mr. Test");
            world.chunks[0][0].addPlayer(testPlayer);
            world.chunks[0][0].addPlayer(new Player("Mr. Dead"));


            System.out.println("I found: " + world.chunks[0][0].getPlayer(testPlayer, "Mr. Dead").getName());


            System.out.println(world.chunks[0][0].getSounds());
        } catch (IllegalStateException OB) {
            // System.out.println(OB);
        }
    }
}
