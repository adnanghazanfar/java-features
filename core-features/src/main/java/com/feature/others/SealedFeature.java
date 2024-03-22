package com.feature.others;

public class SealedFeature {

  sealed class AbstractFile permits MP3File {}

  final class MP3File extends AbstractFile {}

}
