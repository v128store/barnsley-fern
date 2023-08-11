package fern

import java.awt.Color
import java.awt.image.BufferedImage

object Main extends App {
  println("Starting...")
  val canvas = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB)
  val g      = canvas.getGraphics

  val random = scala.util.Random

  println("Drawing...")
  g.setColor(Color.green)
  val x = 0.5
  val y = 0.0
  paint(x, y, 100000)

  println("Save file...")
  javax.imageio.ImageIO.write(canvas, "png", new java.io.File("drawing.png"))
  println("Completed")

  @scala.annotation.tailrec
  def paint(x: Double, y: Double, i: Int): Unit = {
    if (i > 0) {
      val rand = random.nextDouble
      val (x1, y1) =
        if (rand < 0.85)
          (0.85 * x + 0.04 * y, -0.04 * x + 0.85 * y + 1.6)
        else if (rand < 0.86)
          (0.0, 0.16 * y)
        else if (rand < 0.93)
          (0.2 * x - 0.26 * y, 0.23 * x + 0.22 * y + 1.6)
        else
          (-0.15 * x + 0.28 * y, 0.26 * x + 0.24 * y + 0.44)

      g.fillRect((66.0 * x1 + 200.0).toInt, (66.0 * -y1 + 675.0).toInt, 1, 1)
      paint(x1, y1, i - 1)
    }
  }
}
