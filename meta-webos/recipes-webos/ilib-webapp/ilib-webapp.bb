# Copyright (c) 2017-2019 LG Electronics, Inc.

SUMMARY = "iLib code and locale data"
AUTHOR = "Goun Lee <goun.lee@lge.com>"
SECTION = "libs/javascript"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

WEBOS_VERSION = "14.2.0-4_456f7bf6bf7aa71a99559f94b98a0c36122bec6a"
PR = "r6"

inherit webos_arch_indep
inherit webos_enhanced_submissions
inherit webos_public_repo

SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

# Skip the unwanted tasks
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    # ${datadir}/javascript is the standard location where jquery puts its files, so
    # iLib follows suit. iLib is an externally-developed library like jquery.
    install -d ${D}${datadir}/javascript/ilib
    install -v -m 644 ${S}/package.json ${S}/index.js ${D}${datadir}/javascript/ilib
    cp -rv ${S}/js ${S}/lib ${S}/locale ${S}/localedata ${D}${datadir}/javascript/ilib
}

PACKAGES = "${PN}"
FILES_${PN} = "${datadir}/javascript/ilib"
