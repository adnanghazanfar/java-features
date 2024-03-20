package com.feature;

public class SealedFeature {

  sealed class AbstractFile permits MP3File {}

  final class MP3File extends AbstractFile {}

}
