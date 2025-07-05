import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.util.List;

public class RecommenderExample {
    public static void main(String[] args) {
        try {
            DataModel model = new FileDataModel(new File("C:\\Users\\singh\\IdeaProjects\\RecommendSystem\\data.csv"));
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
            Recommender recommender = new GenericItemBasedRecommender(model, similarity);

            int userID = 3;
            List<RecommendedItem> recommendations = recommender.recommend(userID, 3);

            System.out.println("Recommendations for User " + userID + ":");
            if (recommendations.isEmpty()) {
                System.out.println("⚠️ No recommendations found. Try a different user or add more data.");
            } else {
                for (RecommendedItem item : recommendations) {
                    System.out.printf("Item ID: %d | Estimated Rating: %.2f%n", item.getItemID(), item.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
