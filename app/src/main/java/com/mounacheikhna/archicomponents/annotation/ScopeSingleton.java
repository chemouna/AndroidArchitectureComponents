package com.mounacheikhna.archicomponents.annotation;

import javax.inject.Scope;

@Scope public @interface ScopeSingleton {
    Class<?> value();
}
