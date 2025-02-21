SUMMARY = "A VNC server library"
HOMEPAGE = "https://github.com/any1/neatvnc"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/any1/neatvnc.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "pixman libxkbcommon wayland wayland-protocols aml libdrm"


inherit meson pkgconfig
