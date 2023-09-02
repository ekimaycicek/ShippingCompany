
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ShippingBusinessDistribution {

        public static void main(String[] args) {


            int numberOfVehicles = 40;
            int numberOfStones = 100;
            int minStoneWeight = 7;
            int maxStoneWeight = 25;
            int vehicleCapacity = 35;

            Random random = new Random();
            List<Integer> StoneWeightList = new ArrayList<>();
            for (int i = 0; i < numberOfStones; i++) {
                int stoneWeight = random.nextInt(maxStoneWeight - minStoneWeight + 1) + minStoneWeight;
                StoneWeightList.add(stoneWeight);
            }


            List<List<Integer>> vehicleList = new ArrayList<>();
            for (int i = 0; i < numberOfVehicles; i++) {
                vehicleList.add(new ArrayList<>());
            }

            int stoneIndex = 0;
            while (stoneIndex < numberOfStones) {
                boolean stonedOut = false;
                for (int i = 0; i < numberOfVehicles && stoneIndex < numberOfStones; i++) {
                    List<Integer> vehicle = vehicleList.get(i);
                    int totalWeight = vehicle.stream().mapToInt(Integer::intValue).sum();
                    int stoneWeight = StoneWeightList.get(stoneIndex);
                    if (totalWeight + stoneWeight <= vehicleCapacity) {
                        vehicle.add(stoneWeight);
                        stonedOut = true;
                        stoneIndex++;
                    }
                }
                if (!stonedOut) {
                    break;
                }
            }


            for (int i = 0; i < vehicleList.size(); i++) {
                List<Integer> vehicle = vehicleList.get(i);
                System.out.println("Vehicle " + (i + 1) + ": " + vehicle);
                int totalWeight = vehicle.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total weight: " + totalWeight + " ton");
                System.out.println();
            }
        }
    }
//30-35 ton arası dağıtacak
//en az 30