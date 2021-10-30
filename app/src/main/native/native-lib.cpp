//
// Created by Mayank Agarwal on 10/30/21.
//

#include <jni.h>
#include <string>

extern "C" {

JNIEXPORT jstring JNICALL
Java_com_example_popularmovies_viewModels_MainViewModel_getApiKey(
        JNIEnv *env, jobject /*instance*/) {
    std::string apiKey = "MzhhNzNkNTk1NDZhYTM3ODk4MGE4OGI2NDVmNDg3ZmM=";
    return env->NewStringUTF(apiKey.c_str());
}

}

