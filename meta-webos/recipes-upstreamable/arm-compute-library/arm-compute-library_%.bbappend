# Copyright (c) 2024-2025 LG Electronics, Inc.

EXTENDPRAUTO:append = "webos2"

export CCACHE_MAXSIZE = "1G"

SRC_URI = " \
    git://github.com/ARM-software/ComputeLibrary.git;nobranch=1;protocol=https \
    file://0001-webos-build-support.patch \
    file://0001-OpenCL-dlopen-libOpenCL.so.1-instead-of-libO.patch \
    file://0001-Fix-build-with-gcc-13.patch \
    file://arm-compute-library.pc.in \
"
