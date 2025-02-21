DESCRIPTION = "Weston-based image with WayVNC for remote access"
LICENSE = "CLOSED"

require recipes-graphics/images/core-image-weston.bb

IMAGE_INSTALL:append = " wayvnc"

# Ensure Weston and WayVNC are installed in the image
IMAGE_INSTALL:append = " weston wayvnc"
IMAGE_INSTALL:append = " weston"

IMAGE_INSTALL:append = " systemd systemd-analyze systemd-boot systemd-extra-utils"



DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""




SYSTEMD_AUTO_ENABLE:append = " weston-headless wayvnc"


SYSTEMD_AUTO_ENABLE:append = " weston-headless"


# Enable systemd services after installation
SYSTEMD_AUTO_ENABLE:append = " weston wayvnc"


