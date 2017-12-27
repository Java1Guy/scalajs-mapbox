package example

import io.github.bbarker.L
import io.github.bbarker.L.mapbox.mapboxGl
import io.github.bbarker.L.MapboxDraw
import org.scalajs.dom
//import org.scalajs.dom
import scala.scalajs.js.Dynamic.{ global => g }

import scala.scalajs.js
//import org.scalajs.dom.html
import scala.scalajs.js.annotation._

@JSExportTopLevel("DrawApp")
class DrawApp {
    /*setup*/
  var map:L.mapbox.MapGL = _
  var draw:MapboxDraw = _
  @JSExport
  def updateArea(
      eventType: String,
      e: js.Object
    ): Unit = {
    println(">>> updateArea "+eventType)
    var data = draw.getAll()
    var answer = dom.document.getElementById("calculated-area")
    if (data.features.length > 0) {
        var area:Double = g.turf.area(data).asInstanceOf[Double]
  //      // restrict to area to 2 decimal points
        var rounded_area = Math.round(area * 100)/100
        answer.innerHTML = "<p><strong>" + rounded_area + "</strong></p><p>square meters</p>"
    } else {
      answer.innerHTML = ""
        if (eventType != "draw.delete") g.alert("Use the draw tools to draw a polygon!")
    }
  }


  @JSExport
  def main(): Unit = {
    println(">>> DrawApp.main()")
    mapboxGl.accessToken = "pk.eyJ1IjoibWFya2NoYW5jZSIsImEiOiJLbWdpbzRzIn0.pJdDGMNCnwr5A4rWzWA5bQ"
    /* eslint-disable */
    map = new L.mapbox.MapGL(
      js.Dynamic.literal(
        "container" -> "map",
        "style" -> "mapbox://styles/mapbox/satellite-v9", //hosted style id
        "center" -> js.Array(-91.874, 42.760), // starting position
        "zoom" -> 12 // starting zoom
      )
    )
    draw = new MapboxDraw(
      js.Dynamic.literal(
        "displayControlsDefault" -> false,
        "controls" -> js.Dynamic.literal(
          "polygon" -> true,
          "trash" -> true
        )
      )
    )
    map.addControl(draw)
    // Always gets "evented.js:94 Uncaught TypeError: i[s].call is not a function"
    // map.on("draw.create", (e: js.Object) => {
    //   var data = draw.getAll()
    //   ...)
    // }
    // map.on("draw.delete", updateArea)
    // map.on("draw.update", updateArea)
  }

  @JSExport
  def getMap: L.mapbox.MapGL = map
}
