// Smart Home Lighting Automation using Lambdas

@FunctionalInterface
interface LightBehavior {
    void activate();
}

class SmartLight {
    private String lightId;

    SmartLight(String id) {
        this.lightId = id;
    }

    public void trigger(LightBehavior behavior) {
        System.out.print("Light " + lightId + ": ");
        behavior.activate();
    }
}

public class SmartLightDemo {
    public static void main(String[] args) {
        SmartLight livingRoomLight = new SmartLight("LivingRoom");
        SmartLight bedroomLight = new SmartLight("BedRoom");

        // Define behaviors using Lambdas
        LightBehavior motionTrigger = () -> System.out.println("Turning ON due to motion detected.");
        LightBehavior nightTimeTrigger = () -> System.out.println("Dimming lights for night mode.");
        LightBehavior voiceCommandTrigger = () -> System.out.println("Changing color to Blue via voice command.");
        LightBehavior partyMode = () -> System.out.println("Flashing lights in Party Mode 🎉");

        // Simulate different triggers
        livingRoomLight.trigger(motionTrigger);
        livingRoomLight.trigger(nightTimeTrigger);
        bedroomLight.trigger(voiceCommandTrigger);
        bedroomLight.trigger(partyMode);
    }
}
