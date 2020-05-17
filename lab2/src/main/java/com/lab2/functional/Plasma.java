package com.lab2.functional;

import java.awt.image.BufferedImage;

import static com.lab2.functional.Transform.floatToColor;

public class Plasma {

     float[][] x;

    public BufferedImage createPlasma(int countLevels)
    {
        int size = (int)Math.round(Math.pow(2, countLevels));
        BufferedImage image = new BufferedImage(size + 1, size + 1,
                BufferedImage.TYPE_INT_RGB);
        x = new float[size + 1][size + 1];
        x[0][0] = (float)Math.random() * size / 2 - size / 4;
        x[0][size] = (float)Math.random() * size / 2 - size / 4;
        x[size][0] = (float)Math.random() * size / 2 - size / 4;
        x[size][size] = (float)Math.random() * size / 2 - size / 4;
        calc(0, 0, size, size);
        float min = Float.MAX_VALUE;
        float max = Float.MIN_VALUE;
        for (int i = 0; i <= size; ++i)
        {
            for (int j = 0; j <= size; ++j)
            {
                if (x[i][j] < min)
                {
                    min = x[i][j];
                }
                if (x[i][j] > max)
                {
                    max = x[i][j];
                }
            }
        }

        for (int i = 0; i <= size; ++i)
        {
            for (int j = 0; j <= size; ++j)
            {
                image.setRGB(j, i,
                        floatToColor((x[i][j] - min) / (max - min)).getRGB());
            }
        }
        return image;
    }

    private void calc(int a, int b, int c, int d)
    {
        if (a + 1 == c || b + 1 == d)
        {
            return;
        }
        float r = (c - a) + (d - b);
        int e  = (a + c) / 2;
        int f = (b + d) / 2;
        x[e][f] =
                (x[a][b] + x[a][d] + x[c][b] + x[c][d]) / 4 +
                        r * (float)(Math.random() - .5);
        x[e][b] = (x[a][b] + x[c][b]) / 2;
        x[e][d] = (x[a][d] + x[c][d]) / 2;
        x[a][f] = (x[a][b] + x[a][d]) / 2;
        x[c][f] = (x[c][b] + x[c][d]) / 2;
        calc(a, b, e, f);
        calc(a, f, e, d);
        calc(e, b, c, f);
        calc(e, f, c, d);
    }
}
