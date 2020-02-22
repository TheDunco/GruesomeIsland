public class GruesomeIsland {
    public static void main(String[] args) {
        World world = new World(10);
        world.showMatrix();
        try {
            int[] test = new int[2];
            test = world.chunks[3][3].getAdjacentChunk("East");

            System.out.println(test[0]);
             System.out.println(test[1]);
        }
        catch(IllegalStateException OB) {
            // System.out.println(OB);
        }
    }
}
