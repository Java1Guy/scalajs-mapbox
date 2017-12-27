package io.github.bbarker.L.mapbox

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation._

import io.github.bbarker.L._
import Helpers._

/**
 * Created by Brandon Elam Barker on 7/22/2015.
 */



@js.native
@JSGlobal("L.mapbox.FeatureLayer")
class FeatureLayer (mapDescriptor: MapDescriptor = null,
                    options: js.Object = null
                   ) extends FeatureGroup {


}

@js.native
@JSGlobal("L.mapbox")
object mapBox extends js.Object {
  var accessToken: String = js.native

  def featureLayer(mapDescriptor: String = null,
                   options: js.Object = null
                  ): FeatureLayer = js.native
}

@js.native
@JSGlobal("mapboxgl")
object mapboxGl extends js.Object {
  var accessToken: String = js.native

  def featureLayer(mapDescriptor: String = null,
                   options: js.Object = null
                  ): FeatureLayer = js.native
}


@js.native
@JSGlobal("mapboxgl.Map")
class MapGL (
            options: js.Object = null
          ) extends js.Object {
  def addControl(control: Control): Map = js.native

  type MapControlCallback = (js.Object) => Unit
  // @TODO can't get this to work...
  // Always gets "evented.js:94 Uncaught TypeError: i[s].call is not a function"
  // when it tries to call the handler
  def on(event: String, handler: MapControlCallback = null): Map = js.native
}

//  This is the mapbox.js interface
@js.native
@JSGlobal("L.mapbox.Map")
class Map (domElement: String,
           mapDescriptor: MapDescriptor,
           options: js.Object = null
          ) extends js.Object {

  def addLayer(layer: Layer): Map = js.native

  val attributionControl: ControlAttribution = js.native

  def closePopup(): Map = js.native

  def hasLayer(layer: Layer): Boolean = js.native

  def fitBounds(
                 latlng: LatLngBounds,
                 options: js.Object = null
                 ): Map = js.native

  def removeLayer(layer: Layer): Map = js.native

  def setView(coords: js.Array[Double], zoom: Int): Map = js.native

  def removeControl (control:Control): Map = js.native

}

