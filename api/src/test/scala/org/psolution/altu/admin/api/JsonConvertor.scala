package org.psolution.altu.admin.api

import java.util.Locale

import org.psolution.altu.admin.api.model.{Menu, MenuItem}
import org.scalatest.{FlatSpec, Matchers}

import spray.json._
import fommil.sjs.FamilyFormats._

import scala.collection.mutable.ListBuffer

class JsonConvertor extends FlatSpec with Matchers{


  "Convert into" should "has the next structure" in {
    var items = new ListBuffer[MenuItem];
    items += MenuItem(Locale.US, "Dashboard")
    items += MenuItem(Locale.US, "Settings")

    val menu = Menu(items).toJson;

  }




}
