package test.floor.plan.flooplan;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.util.FloorPlan;

public class FlooPlanApplicationTests {
    private FloorPlan floorPlan;
    private Points points;
    List<Points> pointsList;
    List<Points> pointsList1;
    List<Points> wrongList;
    List<Points> wrongList1;

    @Before
    public void setUp() {
        floorPlan = new FloorPlan();
        points = new Points();
        pointsList = new ArrayList<>();
        pointsList1 = new ArrayList<>();
        wrongList = new ArrayList<>();
        wrongList1 = new ArrayList<>();

        points.setCoordinateX(1);
        points.setCoordinateY(1);
        pointsList.add(points);
        pointsList1.add(points);
        wrongList.add(points);

        points.setCoordinateX(1);
        points.setCoordinateY(2);
        pointsList.add(points);
        pointsList1.add(points);
        wrongList.add(points);

        points.setCoordinateX(2);
        points.setCoordinateY(2);
        pointsList.add(points);

        points.setCoordinateX(2);
        points.setCoordinateY(1);
        pointsList.add(points);

        points.setCoordinateX(0);
        points.setCoordinateY(2);
        pointsList1.add(points);

        points.setCoordinateX(0);
        points.setCoordinateY(3);
        pointsList1.add(points);

        points.setCoordinateX(2);
        points.setCoordinateY(3);
        pointsList1.add(points);

        points.setCoordinateX(2);
        points.setCoordinateY(1);
        pointsList1.add(points);
    }

    @Test
    public void testOk() {
        Assert.assertEquals(true, floorPlan.floorChecker(pointsList));
        Assert.assertEquals(true, floorPlan.floorChecker(pointsList1));
    }
    @Test
    public void testWrong() {
        Assert.assertEquals(false, floorPlan.floorChecker(wrongList));
        Assert.assertEquals(false, floorPlan.floorChecker(wrongList1));
    }
}
