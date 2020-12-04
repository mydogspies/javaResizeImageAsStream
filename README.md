# javaResizeImageAsStream
After scratching my head a long time how to resize images on the fly while retaining high enough quality, especially if those images are saved as byte arrays in a database, I fould one solution using the ImageJ library.
This function takes an image stream, does the magic by using the built-in gaussian blur and resizing functions of ImageJ and then returns a new  image stream.

The ImageJ source can be found here: https://github.com/imagej/imagej
The maven central dependency is here: https://mvnrepository.com/artifact/net.imagej/ij/1.53g

This here is the original discussion on stackoverflow with the hint to use ImageJ: https://stackoverflow.com/questions/24745147/java-resize-image-without-losing-quality
And another post on the topic of converting between streams and BufferedImage: https://stackoverflow.com/questions/4251383/how-to-convert-bufferedimage-to-inputstream/21569243

All that above has no guarantee to actually work and not cause some side effects. If you have any ideas on how to make the flow;  stream -> image magic -> stream, then please post here in issues :-)
