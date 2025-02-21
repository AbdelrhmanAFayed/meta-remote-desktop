SUMMARY = "Asynchronous event library"
HOMEPAGE = "https://github.com/any1/aml"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/any1/aml.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit meson pkgconfig
