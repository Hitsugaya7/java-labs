package com.lab2.functional;

import java.awt.*;

public class Transform {

    static Color floatToColor(float x)
    {
        if (x <= 0)
        {
            return new Color(1f, 0f, 0f);
        }
        if (x <= 1f/6)
        {
            return new Color(1f, x * 6f, 0f);
        }
        if (x <= 2f/6)
        {
            return new Color(1f - (x - 1f/6) * 6f, 1f, 0f);
        }
        if (x <= 3f/6)
        {
            return new Color(0f, 1f, (x - 2f/6f) * 6f);
        }
        if (x <= 4f/6)
        {
            return new Color(0f, 1f - (x - 3f/6f) * 6f, 1f);
        }
        if (x <= 5f/6)
        {
            return new Color((x - 4f/6) * 6f, 0f, 1f);
        }
        if (x < 1f)
        {
            return new Color(1f, 0f, 1f - (x - 5f/6f) * 6f);
        }
        return new Color(1f, 0f, 0f);
    }
}
