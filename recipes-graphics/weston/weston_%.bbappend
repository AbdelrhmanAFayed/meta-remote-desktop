FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://weston-rdp.service"

PACKAGECONFIG:append = " rdp"


do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/weston-rdp.service ${D}${systemd_system_unitdir}/weston-rdp.service
}

FILES:${PN} += "${systemd_system_unitdir}/weston-rdp.service"

SYSTEMD_SERVICE:${PN} = "weston-rdp.service"
