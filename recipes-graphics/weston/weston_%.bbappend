FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://weston-headless.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/weston-headless.service ${D}${systemd_system_unitdir}/weston-headless.service
}

FILES:${PN} += "${systemd_system_unitdir}/weston-headless.service"
FILES_${PN} += "${libdir}/libweston-10/headless-backend.so"

PACKAGECONFIG:append = " headless"


SYSTEMD_SERVICE:${PN} = "weston-headless.service"
