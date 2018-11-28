package com.qualogy.klusdus.google.model.assistant

enum class ImageDisplayOptions {
    /** 	Fill the gaps between the image and the image container with gray bars. */
    DEFAULT,
    /** Fill the gaps between the image and the image container with white bars. */
    WHITE,
    /**
     * Image is scaled such that the image width and height match or exceed the container dimensions.
     * This may crop the top and bottom of the image if the scaled image height is greater than the container height,
     * or crop the left and right of the image if the scaled image width is greater than the container width.
     * This is similar to "Zoom Mode" on a widescreen TV when playing a 4:3 video.
     */
    CROPPED
}