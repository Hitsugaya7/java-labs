package com;

import kotlin.Metadata;
import kotlin.io.ConsoleKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 16},
        bv = {1, 0, 3},
        k = 2,
        d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\b\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0019\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a \u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0002\u001a \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0004¨\u0006\u0016"},
        d2 = {"cos", "", "x", "precision", "", "getAngleValue", "getPrecisionValue", "main", "", "args", "", "", "([Ljava/lang/String;)V", "nextSequenceElement", "i", "prevElement", "precisionIsChanging", "", "sum", "nextElement", "round", "decimals", "lab1"}
)
public final class Main {
    public static void main(@NotNull String[] args) throws Throwable {
        Intrinsics.checkParameterIsNotNull(args, "args");

        while (true) {
            try {
                double x = getAngleValue();
                int precision = getPrecisionValue();
                String var4 = "sin(" + x + ")=" + sin(x, precision);
                System.out.println(var4);
            } catch (Exception var6) {
                String var2 = var6.getMessage();
                System.out.println(var2);
            }
        }
    }

    public static int getPrecisionValue() throws Throwable {
        String var0 = "Enter precision (Integer value): ";
        boolean var1 = false;
        System.out.print(var0);

        try {
            String var10000 = ConsoleKt.readLine();
            if (var10000 == null) {
                Intrinsics.throwNpe();
            }

            var0 = var10000;
            int var6 = Integer.parseInt(var0);
            if (var6 > 308) {
                throw new IllegalArgumentException("Too large value for precision. Max precision 308 decimal places");
            } else if (var6 < 0) {
                throw new IllegalArgumentException("Precision must be greater zero.");
            } else {
                return var6;
            }
        } catch (NumberFormatException var5) {
            throw new IllegalArgumentException("Incorrect input. Please, enter Integer value.");
        }
    }

    public static double getAngleValue() throws Throwable {
        String var0 = "Enter the angle value in radians (Double value) X = ";
        System.out.print(var0);

        try {
            String var10000 = ConsoleKt.readLine();
            if (var10000 == null) {
                Intrinsics.throwNpe();
            }

            var0 = var10000;
            return Double.parseDouble(var0);
        } catch (NumberFormatException var2) {
            throw new IllegalArgumentException("Incorrect input. Please, enter Double value.");
        }
    }

    public static double sin(double x, int precision) {
        double angleInRadians = x % 6.283185307179586D;
        double currentElement = x;
        double sum = 0.0D;

        for (int var9 = 1; precisionIsChanging(sum, precision, currentElement); currentElement = nextSequenceElement(var9++, angleInRadians, currentElement)) {
            sum += currentElement;
        }

        return round(sum, precision);
    }

    private static double nextSequenceElement(double i, double x, double prevElement) {
        double var10000 = (double) -1 * prevElement;
        double var7 = 2.0D;
        double var12 = Math.pow(x, var7);
        return var10000 * (var12 / ((2 * i + 1) * 2 * i));
    }

    private static boolean precisionIsChanging(double sum, int precision, double nextElement) {
        return Double.compare(round(sum, precision), round(sum + nextElement, precision)) != 0;
    }

    public static double round(double $this$round, int decimals) {
        double multiplier = 1.0D;
        int var10 = 0;

        for (; var10 < decimals; ++var10) {
            multiplier *= 10;
        }

        return (double) MathKt.roundToLong($this$round * multiplier) / multiplier;
    }
}
