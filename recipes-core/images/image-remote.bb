DESCRIPTION = "Weston-based image with RDP for remote access"
LICENSE = "CLOSED"

require recipes-graphics/images/core-image-weston.bb

# Install required packages
IMAGE_INSTALL:append = " weston weston-init freerdp"

# Enable systemd
DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

# Enable Weston RDP service at boot
SYSTEMD_AUTO_ENABLE:append = " weston-rdp"

SYSTEMD_SERVICE:${PN} = "weston-rdp.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

ROOTFS_POSTPROCESS_COMMAND:append = " generate_rdp_cert; "

generate_rdp_cert() {
    install -d ${IMAGE_ROOTFS}/etc/weston
    openssl req -new -x509 -days 365 -nodes \
        -out ${IMAGE_ROOTFS}/etc/weston/rdp-cert.pem \
        -keyout ${IMAGE_ROOTFS}/etc/weston/rdp-key.pem \
        -subj "/CN=weston-rdp"
}

