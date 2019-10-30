SUMMARY = "Python bindings for the DBus inter-process communication system"
SECTION = "devel/python"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
LICENSE = "MIT & AFL-2.1 | GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b03240518994df6d8c974675675e5ca4 \
    file://dbus-gmain/COPYING;md5=99fece6728a80737c8fd3e7c734c17c4 \
    "

DEPENDS = "expat dbus dbus-glib virtual/libintl"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-python/dbus-python-${PV}.tar.gz"

SRC_URI[md5sum] = "428b7a9e7e2d154a7ceb3e13536283e4"
SRC_URI[sha256sum] = "cdd4de2c4f5e58f287b12013ed7b41dee81d503c8d0d2397c5bd2fb01badf260"

S = "${WORKDIR}/dbus-python-${PV}"

inherit distutils3-base autotools pkgconfig

RDEPENDS_${PN} = "python3-io python3-logging python3-stringold python3-threading python3-xml"

clean_up_dev() {
    # Remove files that clash with python-dbus-dev; their content is same and we've got
    # python-dbus-dev separated out from this and python-dbus to allow it to build
    # and package out right so it can cleanly be used elsewhere...
    rm -rf ${D}${includedir} 
    rm -rf ${D}${libdir}/pkgconfig
}
do_install[postfuncs] += "clean_up_dev "

PACKAGES = "${PN} ${PN}-dbg"

BBCLASSEXTEND = "native nativesdk"
