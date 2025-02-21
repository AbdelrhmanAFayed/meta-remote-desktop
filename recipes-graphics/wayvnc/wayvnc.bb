SUMMARY = "A Wayland-native VNC server"
HOMEPAGE = "https://github.com/any1/wayvnc"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/any1/wayvnc.git;protocol=https;branch=master"
SRCREV = "82d60179f0149be3ef12ef2cced7061d29f31d14"

# SRCREV = "${AUTOREV}"


S = "${WORKDIR}/git"

DEPENDS = "pixman libxkbcommon wayland wayland-protocols aml neatvnc jansson"

DEPENDS += "wayland-native"

inherit meson pkgconfig systemd

FILES_${PN} += "${bindir}/wayvnc"

# Ensure systemd service file is included
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append = " file://wayvnc.service"

do_install() {
    # Install the WayVNC binary
    install -d ${D}${bindir}
    install -m 0755 ${B}/wayvnc ${D}${bindir}/

    # Install the systemd service
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/wayvnc.service ${D}${systemd_system_unitdir}/wayvnc.service
}

FILES:${PN} += "${systemd_system_unitdir}/wayvnc.service"

# Enable the systemd service
SYSTEMD_SERVICE:${PN} = "wayvnc.service"
