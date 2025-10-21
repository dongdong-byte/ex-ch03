#!/bin/bash
rm -rf build
rm -rf .gradle
./gradlew clean build --refresh-dependencies
