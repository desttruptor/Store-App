package com.example.storeapp.data.resourcemanager;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

public interface ResourceManager {
    /**
     * Get string defined in strings.xml
     *
     * @param stringRes link identifier
     * @return requested string, null if string was not found
     */
    @NonNull
    String getString (@StringRes int stringRes);
}
