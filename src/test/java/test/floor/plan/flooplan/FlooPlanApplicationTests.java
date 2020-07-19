package test.floor.plan.flooplan;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.floor.plan.flooplan.models.Points;
import test.floor.plan.flooplan.util.FloorPlan;
import test.floor.plan.flooplan.util.ParseData;

public class FlooPlanApplicationTests {
    private FloorPlan floorPlan;
    private ParseData parseData;
    List<Points> pointsList;
    List<Points> pointsList1;
    List<Points> wrongList;
    List<Points> wrongList1;

    @Before
    public void setUp() {
        floorPlan = new FloorPlan();
        pointsList1 = new ArrayList<>();
        wrongList = new ArrayList<>();
        wrongList1 = new ArrayList<>();
        parseData = new ParseData();

        Points points = new Points();
        points.setFirst(1);
        points.setSecond(1);
        pointsList1.add(points);
        wrongList.add(points);

        Points points1 = new Points();
        points1.setFirst(1);
        points1.setSecond(2);
        pointsList1.add(points1);
        wrongList.add(points1);

        Points points2 = new Points();
        points2.setFirst(0);
        points2.setSecond(2);
        pointsList1.add(points2);

        Points points3 = new Points();
        points3.setFirst(0);
        points3.setSecond(3);
        pointsList1.add(points3);

        Points points4 = new Points();
        points4.setFirst(2);
        points4.setSecond(3);
        pointsList1.add(points4);

        Points points5 = new Points();
        points5.setFirst(2);
        points5.setSecond(1);
        pointsList1.add(points5);
    }

    @Test
    public void testOk() {
        Assert.assertEquals(true, floorPlan.floorChecker(pointsList1));
    }

    @Test
    public void testWrong() {
        Assert.assertEquals(false, floorPlan.floorChecker(wrongList));
        Assert.assertEquals(false, floorPlan.floorChecker(wrongList1));
    }

    @Test
    public void testParseOk() {
        Assert.assertEquals(pointsList1, parseData.parse("1,1;1,2;0,2;0,3;2,3;2,1"));
    }
}
