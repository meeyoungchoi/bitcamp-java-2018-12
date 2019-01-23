package design_pattern.templet_method;

public class UnitFactory {
	public static final int RESTAURANT = 1;
	public static final int TRAINING_CENTER = 2;
	
	//객체 생성 과정이 복잡한 경우~
	public Unit createUnit(int building ) {
		Unit unit = null;
		switch(building) {
		case RESTAURANT:
		return createRestaurant();
		case TRAINING_CENTER:
		return createTrainingCenter();
		}
		
		return null;
	
	}
	
	private Unit createRestaurant() {
		Unit unit = new Restaurant();
		unit = new Restaurant();
		unit.setName("군인식당");
		unit.setArea(50);
		unit.setType(Unit.GENERAL_BUILDING);
		return unit;
	}
	
	private Unit createTrainingCenter() {
		Unit unit= new TrainingCenter();
		unit.setArea(500);
		unit.setName("훈련소");
		unit.setType(Unit.GENERAL_BUILDING);
		return unit;
	}
}
