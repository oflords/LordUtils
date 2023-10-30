package dev.oflords.lordutils.server;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class PerformanceUtil {
    private static DecimalFormat format = new DecimalFormat("##.##");

    public static String getMemory() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1048576L + "/" + runtime.totalMemory() / 1048576L;
    }

    public static String getNiceTPS() {
        double tps = getTPS()[0];

        if (tps > 20.00) {
            return "20*";
        } else {
            return format.format(tps);
        }
    }

    public static double[] getTPS() {
        Object server = null;
        Field tps = null;
        try {
            if (server == null) {
                Server mc = Bukkit.getServer();

                Field consoleField = mc.getClass().getDeclaredField("console");
                consoleField.setAccessible(true);
                server = consoleField.get(mc);
            }
            if (tps == null) {
                tps = server.getClass().getSuperclass().getDeclaredField("recentTps");
                tps.setAccessible(true);
            }
            return (double[]) tps.get(server);
        } catch (IllegalAccessException | NoSuchFieldException ignored) {

        }
        return new double[]{20, 20, 20};
    }
}
